package io.github.soloyolo.clients.battlenet.payloads;

import lombok.Data;

@Data
public class Crest {

    CrestElement background;
    CrestElement border;
    CrestElement emblem;

}

@Data
class CrestElement {

    Color color;
    int id;
    Media media;

}
