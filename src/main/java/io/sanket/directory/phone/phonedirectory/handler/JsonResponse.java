package io.sanket.directory.phone.phonedirectory.handler;

public class JsonResponse<A> {

    private int status = 404;
    private String message = null;
    private A data = null;

    public JsonResponse(){}

    public JsonResponse(String message, A data){
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public A getData() {
        return data;
    }

    public void setData(A data) {
        this.data = data;
    }

    public String toString(){
        return "{ \n {"+ data + "}\n"+
                "\"status\":"+ this.status +",\n"
                + "\"message\":\""+ this.message +"\"\n}";
    }

}
