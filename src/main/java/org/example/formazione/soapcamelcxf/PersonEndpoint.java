package org.example.formazione.soapcamelcxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface PersonEndpoint {
    @WebMethod
    String person(@WebParam(name = "PersonDTO") PersonDTO personDTO);
}

