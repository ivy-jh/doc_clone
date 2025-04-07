.. _sso-custom-solution:

Custom SSO Solution
===================

Our built-in solutions may not fit your needs - but you may implement your own
Single Sign-on solution by implementing a Tomcat Valve and register this valve
in :ref:`context-xml`. A valve is something which will be executed for every
request sent to the Axon Ivy Engine. 

This is our Single Sign-on valve. Use it as template and adapt it your needs:

.. literalinclude:: ../../../../target/resources/includes/sso/SingleSignOnValve.java
   :language: java
