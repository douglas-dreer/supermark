package br.com.supermark.domain.validators

interface Validator<T> {
    fun validate(value: T)
}