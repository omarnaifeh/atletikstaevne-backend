package com.omar1907.atletikstaevne.models;

import com.omar1907.atletikstaevne.enums.Shape;
import com.omar1907.atletikstaevne.enums.Surface;
import com.omar1907.atletikstaevne.enums.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private Type type;

    @Enumerated(EnumType.ORDINAL)
    private Shape shape;

    @Enumerated(EnumType.ORDINAL)
    private Surface surface;

    private Integer length;

    private Integer lanes;

}
