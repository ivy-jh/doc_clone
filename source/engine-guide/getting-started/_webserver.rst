.. Note::
  The Axon Ivy Engine internal web server provides connectors for the following
  protocols:

  * The **HTTP** Protocol is used by web browsers to communicate with a web
    server. This protocol is not secure since the communication is not
    encrypted. Axon Ivy Engine uses port 8080 for HTTP by default.

  * **HTTPS** is like HTTP, but secure. It uses TLS to encrypt all communication
    between the web browser and server. Axon Ivy Engine uses port 8443 for HTTPS
    by default.

  Have a look at the :ref:`ivy.yaml <ivy-yaml>` to see how you can
  adjust parts of the web server and its connectors to your needs.
