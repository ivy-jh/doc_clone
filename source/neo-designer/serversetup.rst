.. _neo-serversetup:

Server setup
------------

The setup of an |ivy-engine| for the low-code development with the 
NEO Designer is straight forward. Download the |ivy-engine| suitable for
your system. Install the engine following the :ref:`Engine Guide <engine-guide>`.
Start the engine. It will run in DEMO-MODE. 
There is no need to configure a production setup like a 
system database or a search engine.

In order to work with the NEO Designer users must authenticate themsleves. 
NEO users are managed in the **default** security system on the engine. 
The default security system must be configured to access an External 
Identity Provider. 
See the :ref:`Configuration chapter <configuration-security-system>` in the Engine Guide.
It is also highly recommended to control the access to the |ivy-engine| 
with a :ref:`reverse-proxy`.   

Users will start NEO Designer in a web browser using the url <ivy-engine>/neo
They have to login with user name and password.
