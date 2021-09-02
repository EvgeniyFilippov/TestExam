package com.filipau.domain.outcome

interface Transformer<InputType, OutputType> {
    var convert: (InputType) -> OutputType
}