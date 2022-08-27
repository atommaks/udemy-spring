package ru.atom.springstarterannotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // во время какого этапа хотим достучаться до аннотации: класс - этап компиляции
@Target(ElementType.FIELD) // где мы будем использовать эту аннотацию(мы будем использовать на филдом)
public @interface InjectBean {

}
