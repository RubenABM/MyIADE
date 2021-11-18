package pt.iade.myiade.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException2 extends RuntimeException {
 private static final long serialVersionUID = 5405519104069955535L;
 public NotFoundException2(String email, String elemType, String idName, String password) {
 super(elemType+" with "+ idName + " " + email + " and password " + password + " not found.");
 }
}