package br.com.course.spring3rest.config.mediatype;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

public class YamlJacksonConverter extends AbstractJackson2HttpMessageConverter {
    protected YamlJacksonConverter() {
        super(
                new YAMLMapper()
                        .setSerializationInclusion(null),
                MediaType.parseMediaType("application/x-yaml")
        );
    }
}
