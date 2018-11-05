
/**
 * MailServerCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package services.mail;

    /**
     *  MailServerCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class MailServerCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public MailServerCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public MailServerCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getMessages method
            * override this method for handling normal response from getMessages operation
            */
           public void receiveResultgetMessages(
                    services.mail.MailServerStub.GetMessagesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMessages operation
           */
            public void receiveErrorgetMessages(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for sendMessage method
            * override this method for handling normal response from sendMessage operation
            */
           public void receiveResultsendMessage(
                    services.mail.MailServerStub.SendMessageResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sendMessage operation
           */
            public void receiveErrorsendMessage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for changerPriorite method
            * override this method for handling normal response from changerPriorite operation
            */
           public void receiveResultchangerPriorite(
                    services.mail.MailServerStub.ChangerPrioriteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from changerPriorite operation
           */
            public void receiveErrorchangerPriorite(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeMessages method
            * override this method for handling normal response from removeMessages operation
            */
           public void receiveResultremoveMessages(
                    services.mail.MailServerStub.RemoveMessagesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeMessages operation
           */
            public void receiveErrorremoveMessages(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for authentifier method
            * override this method for handling normal response from authentifier operation
            */
           public void receiveResultauthentifier(
                    services.mail.MailServerStub.AuthentifierResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from authentifier operation
           */
            public void receiveErrorauthentifier(java.lang.Exception e) {
            }
                


    }
    