package org.example.formazione.soapcamelcxf;

import javax.jws.WebService;

@WebService
public interface PersonEndpoint {
    String person(String name);
}

