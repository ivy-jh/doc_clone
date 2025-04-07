.. _licensing:
.. _license:

Licensing your Engine
=====================

Getting a License
-----------------

To run the Axon Ivy Engine in :ref:`production mode <production-mode>` you need a
license, which you can apply for via your Axon Ivy Partner or Axon Ivy Sales
Representative. You need to provide 

- the Axon Ivy Engine major version (e.g 8, 10, 11)
- the Axon Ivy Engine edition
- the number of named users 
- the number of concurrent users
- the public URLs of your trial engine
- for clusters only, the number of nodes 

for each license. These inputs are detailed below.

.. _license-edition:

Editions
~~~~~~~~

Choose between **Standard Edition** and **Enterprise Edition**. If you expect
high loads or need increased reliability, you should look into the Enterprise
Edition. It allows running the Axon Ivy Engine in a :ref:`cluster <cluster>`.
The maximum number of nodes in the cluster is part of the license.


Named Users
~~~~~~~~~~~~~~~~

Registered users within an Axon Ivy Engine are called **named users (NU)**. These users
have an account in the Axon Ivy Engine and thus can log in to the Axon Ivy
Engine. Every user in the Axon Ivy Engine is considered a Named User. Deactivated users,
administrators and the system user do not count as named users.
All of this also applies to users on a cluster.

Users with the same name, email address and external id over multiple security contexts are
only counted as one Named User.

Concurrent Users
~~~~~~~~~~~~~~~~

The number of users concurrently working on the Axon Ivy Engine is known as
**concurrent users (CU)**. The Axon Ivy Engine counts the number of concurrent
users as follows:

* Every session of every user counts as one concurrent user.

* The system session is not counted as a concurrent user, as all sessions 
  for all administrator users.

* Anonymous sessions do not count as concurrent user.

This also applies to clusters.


Public URLs
~~~~~~~~~~~~~~~~

Public URLs are the links that end users will use to access your Axon Ivy Engine or Cluster.

.. admonition:: Example
  
  Let's assume your Axon Ivy Engine is installed on a machine with the DNS name
  ``axonivyprod``. Users access the Axon Ivy Engine in two different ways:
  
  * Intranet users use ``http://axonivyprod:8080`` to access it. 
  * Internet users use ``https://www.customer.com`` to access it through a reverse proxy.
  * Administrators access the Axon Ivy Engine with an IP Address ``http://192.168.1.19``.
  
  In this case, the license has to contain three public URLs:
  
  * ``axonivyprod``
  * ``www.customer.com``
  * ``192.168.1.19``

  Note: Access via ``localhost``, ``127.0.0.1`` and ``::1`` is always possible
  and is not included in the license.

  For clusters, the Public URL of the load balancer in front of the cluster has
  to be in the license. If you need to access the cluster nodes separately
  (internally), have their IP addresses or DNS names added to the cluster
  license.

Installing your License
-----------------------

There are several ways to install your license.

Docker
~~~~~~

For Containers, all your options for providing the license to the container are
described in :ref:`configuration_containers_license`.

.. _configuration_servers_license:

Linux, and Windows
~~~~~~~~~~~~~~~~~~

For "traditional" server installations, your options to install a license are:

* copy the license to the :file:`configuration` directory of the engine.

* upload the license using the engine cockpit. 

  .. figure:: /_images/engine-cockpit/engine-cockpit-licence.png

  
  You can either drag and drop the license, or select its location using the button
  :guilabel:`+ Choose License`. 

