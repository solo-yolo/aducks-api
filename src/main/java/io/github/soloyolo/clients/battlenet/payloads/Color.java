package io.github.soloyolo.clients.battlenet.payloads;

import lombok.Data;

@Data
public class Color {

    int id;
    Rgba rgba;

}

@Data
class Rgba {

    int r;
    int g;
    int b;
    double a;

}
