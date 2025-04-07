.. _integration:

Integration
************

A minimal setup of a productive Axon Ivy Engine environment only requires the
Axon Ivy Engine itself and a database management system to hold the system
database. But to increase security, performance and reliability, other services
have to be installed and integrated additionally.

|

.. graphviz:: overview.dot

|


* :ref:`reverse-proxy`:
  To increase security, users should always access the Axon Ivy Engine via a
  reverse proxy like NGINX, Apache HTTP Server or Microsoft IIS.
* :ref:`User Management <configuration-security-system>`:
  Users can be imported from an external user management system like Microsoft
  Active Directory or Novell eDirectory.
* :ref:`Cluster <cluster>`:
  For scalability, to increase performance and provide high availability, you
  can cluster the Axon Ivy Engine. 
* :ref:`OpenSearch <opensearch>`:
  An OpenSearch server is bundled with the Axon Ivy Engine. For systems with
  high loads, consider to install the OpenSearch Server on a dedicated node,
  or even to run an OpenSearch cluster.
* :ref:`systemdb`:
  The Axon Ivy Engine needs a relational database management system to store its
  workflow data. The Axon Ivy engine stores its data in the **system database**.
  It is a SQL database hosted on one of the supported Database Management
  Systems.


.. toctree::
    :maxdepth: 1
    :hidden:

    identity-provider/index
    reverse-proxy/index
    single-sign-on/index
    cluster/index
    opensearch/index
