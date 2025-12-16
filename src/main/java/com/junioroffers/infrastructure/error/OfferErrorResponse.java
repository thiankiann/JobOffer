package com.junioroffers.infrastructure.error;

import org.springframework.http.HttpStatus;

record OfferErrorResponse(String message, HttpStatus status) {
}
