Web Services
============

SOAP based web services are often used to integrate various systems. The tooling
of |ivy| makes the integration of remote web services very easy and
intuitive. You don't need to care much about the technical details behind the
scenes.


Call a Remote Web Service
-------------------------

To call a remote web service, you have to register it in the
:ref:`webservice-clients-configuration`. Just add a new web service entry, enter
the WSDL URI and generate a client which you can use later on in your process.

After that, you call the remote web service using a
:ref:`process-element-web-service-call-activity`. Sending data from your
business process to the remote service and the integration of returned data from
the service is easy. It works like other data mapping tables.


Provide a Web Service for Third Parties
---------------------------------------

If you need to expose an interface to your application for third parties, you
may provide it as a SOAP web service.

To define a new web service interface, add a new process of kind
:ref:`Webservice <process-kind-webservice>` to your project. Define the
supported parameters by configuring the
:ref:`process-element-web-service-process-start` event. Now you can implement
the business logic of the web service just like any other process flow.

Once you have implemented the service, start the |ivy-engine| and click the link to
the WSDL service definition. Share this WSDL or the link with the third
parties that need to consume your service.

Getting Started
---------------

Check out our :dev-url:`video tutorials </tutorial>` to see web service
integrations in action.

If you are looking for web service integration examples with |ivy|, have a
look at the :ref:`ConnectivityDemos <importing-demo-projects>` sample project in
the Designer.
