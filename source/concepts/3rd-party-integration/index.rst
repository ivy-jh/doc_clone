.. _3rd-party-integration:

3rd Party Integration
*********************

The basic idea of integrating |ivy| with 3rd party systems is either to
invoke an operation on a external system out of an Ivy process (call; |ivy| is the client) or to have
a remote system invoke an operation in |ivy| (being called; |ivy| is the server). There
are several ways to implement these integrations.

Before integrating a 3rd party system, you should have a look at the
:ref:`|ivy| Market <market>` which may already provides a connector for it.

.. toctree::
   :maxdepth: 2

   restapi
   webservice
   database
   process-extensions
