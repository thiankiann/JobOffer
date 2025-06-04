package com.junioroffers.domain.offer;

class OfferSavingException extends RuntimeException{
    public OfferSavingException(String message) {
        super(String.format(message.toString()));
    }
}
