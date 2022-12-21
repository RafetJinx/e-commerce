package design.ecommerce.core.utilities.results.errorResult;

import design.ecommerce.core.utilities.results.Result;

public class ErrorResult extends Result {
    public ErrorResult(){
        super(false);
    }

    public ErrorResult(String message) {
        super(false, message);
    }
}

