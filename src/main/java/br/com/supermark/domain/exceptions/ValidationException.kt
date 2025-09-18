package br.com.supermark.domain.exceptions

class ValidationException(val errors: List<String> ) : RuntimeException("Validation Errors: ") {
}