
/**
 * CompositeCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package services.mail;

    /**
     *  CompositeCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class CompositeCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public CompositeCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public CompositeCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for accuseBienRecu method
            * override this method for handling normal response from accuseBienRecu operation
            */
           public void receiveResultaccuseBienRecu(
                    services.mail.CompositeStub.AccuseBienRecuResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from accuseBienRecu operation
           */
            public void receiveErroraccuseBienRecu(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for changePerior method
            * override this method for handling normal response from changePerior operation
            */
           public void receiveResultchangePerior(
                    services.mail.CompositeStub.ChangePeriorResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from changePerior operation
           */
            public void receiveErrorchangePerior(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeSpam method
            * override this method for handling normal response from removeSpam operation
            */
           public void receiveResultremoveSpam(
                    services.mail.CompositeStub.RemoveSpamResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeSpam operation
           */
            public void receiveErrorremoveSpam(java.lang.Exception e) {
            }
                


    }
    