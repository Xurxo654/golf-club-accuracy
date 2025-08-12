# ADR-001: Interface Testing Strategy

## Decision
Test interfaces through abstract contract test classes, implementations through concrete test classes that extend the contract.

## Consequences
- ✅ Interface behavior is explicitly documented
- ✅ All implementations guaranteed to behave consistently
- ❌ Slightly more complex test setup initially