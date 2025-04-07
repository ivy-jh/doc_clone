HTTP Headers
============

We recommend using the following additional security headers.

* **Strict-Transport-Security**: Set this header if the Engine is to be
  accessed via HTTPS only. For more information, see:
  `Strict-Transport-Security <https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Strict-Transport-Security>`_.
  You can adjust this in the embedded Tomcat with the pre-configured `HTTP Header Security Filter <https://tomcat.apache.org/tomcat-9.0-doc/config/filter.html#HTTP_Header_Security_Filter>`_
  in the :ref:`web-xml`

* **Content-Security-Policy**: Set this header if you want to reduce the risk of
  having an exploitable Cross-site scripting (XSS) vulnerability. With a
  Content-Security-Policy, you can define from which locations external resources
  can be loaded and if scripts embedded in HTML can be executed. For more
  information, see: `Content Security Policy (CSP) <https://developer.mozilla.org/en-US/docs/Web/HTTP/CSP>`_.

  We recommend implementing these headers on a reverse proxy securing 
  your Axon Ivy Engine. In case you have no reverse proxy, check
  `How do I integrate the Axon Ivy Workflow Frontend in my Web App? <https://community.axonivy.com/d/319-how-do-i-integrate-ivy-workflow-frontend-in-my-web-app>`
  for a CSP example using the embedded Tomcat.

* **Referrer-Policy**: Set this header if you want to control how or if the
  referrer is disclosed to other sites. For more information, see:
  `Referrer-Policy <https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Referrer-Policy>`_
