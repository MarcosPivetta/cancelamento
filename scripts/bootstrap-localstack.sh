#!/usr/bin/env bash
set -euo pipefail
AWS="aws --endpoint-url http://localhost:4566 --region us-east-1 --no-cli-pager"
$AWS sns create-topic --name topico-cancelamentos >/dev/null
TOPIC_ARN=$($AWS sns list-topics --query "Topics[?contains(TopicArn,'topico-cancelamentos')].TopicArn" --output text)
$AWS sqs create-queue --queue-name fila-debitos >/dev/null
QUEUE_URL=$($AWS sqs get-queue-url --queue-name fila-debitos --query 'QueueUrl' --output text)
ACCOUNT_ID=000000000000
QUEUE_ARN=arn:aws:sqs:us-east-1:${ACCOUNT_ID}:fila-debitos
QUEUE_ATTRS=$(cat <<EOF
{
  "Policy": "{\"Version\":\"2012-10-17\",\"Statement\":[{\"Effect\":\"Allow\",\"Principal\":{\"AWS\":\"*\"},\"Action\":\"sqs:SendMessage\",\"Resource\":\"${QUEUE_ARN}\",\"Condition\":{\"ArnEquals\":{\"aws:SourceArn\":\"${TOPIC_ARN}\"}}}]}"
}
EOF
)
echo "$QUEUE_ATTRS" > /tmp/queue_attrs.json
$AWS sqs set-queue-attributes --queue-url "$QUEUE_URL" --attributes file:///tmp/queue_attrs.json
$AWS sns subscribe --topic-arn "$TOPIC_ARN" --protocol sqs --notification-endpoint "$QUEUE_ARN" >/dev/null || true
echo "Export para app:"
echo "export FILA_DEBITOS=fila-debitos"
echo "export TOPICO_CANCELAMENTOS_ARN=$TOPIC_ARN"
