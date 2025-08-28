# Cancelamento de Débitos — Hexagonal (acadêmico, PT-BR)

- **Porta de Entrada**: `PortaDeEntradaCancelarDebito`
- **Caso de Uso**: `CasoDeUsoCancelarDebito` (implementa a porta)
- **Portas de Saída**: `PortaDeSaidaPublicarCancelamento` (SNS) e `PortaDeSaidaPersistencia` (no-op)
- **Adaptadores**: SQS (entrada), SNS (saída)

## Rodar com LocalStack
1. `docker compose up -d`
2. `bash scripts/bootstrap-localstack.sh` (cole os `export ...`)
3. `./mvnw spring-boot:run`

## Mensagem de exemplo (SQS)
```json
{"idDebito":"DBT-123","idCliente":"C-999","valor":450.75,"status":"PENDENTE","criadoEm":"2025-08-26T18:00:00Z"}
```
