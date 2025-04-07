Disable Features
----------------

If certain features of the Engine are not required by the deployed projects,
those features should be disabled.


.. _security-engine-optional-features:

Optional features
^^^^^^^^^^^^^^^^^

The following features can be disabled if they are not used by the deployed
projects:

.. literalinclude:: webserver-disabled-features.yaml
  :language: yaml
  :linenos:


Security Features
^^^^^^^^^^^^^^^^^

The following features impact the security and have a good default (depending on
what's better for security) and should not be changed. These feature flags are
set in the :ref:`ivy-yaml`.

* ``Errors.ShowDetailsToEndUsers`` should always be set to ``false``, so that no
  exception details are shown to end users.
* ``REST.Servlet.CSRF.Protection`` should always be set to ``true``, so that
  the REST APIs require a Cross-Site Request Forgery (CSRF) token by default.
  See :ref:`Secure REST APIs <integration-rest-secure>` for more information about
  secure REST API configuration.
* ``Session.RenewIdOnLogin`` should always be set to ``true``, so that
  the session id is renewed after log in.
  
By default, all cookies (including the session cookies ``JSESSIONID`` and ``IVYSESSIONID``) have set 
the ``same-site`` cookie header to value ``lax``. You can disable or harden XSS
cookie restrictions in :ref:`context-xml`.

TLS
^^^

TLS versions 1.2 and 1.3 are enabled by default. You can disable TLS version 1.2 by setting the 
Java system property ``jdk.tls.client.protocols`` to value ``"TLSv1.3"`` in the :ref:`configuration/jvm.options <jvm-options>` file.

See also property ``jdk.tls.disabledAlgorithms`` that can be set in the JVM's ``conf/security/java.security`` file 
for more options. 
