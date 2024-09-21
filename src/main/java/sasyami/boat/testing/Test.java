package sasyami.boat.testing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Test {
    @Value("${spring.datasource.url}")
    public String val;
}
