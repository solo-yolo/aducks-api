package io.github.soloyolo.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Crest {

    String backgroundColor;
    String emblem;
    String emblemColor;
    String border;
    String borderColor;
}
