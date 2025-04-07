.. _multi-tenancy-security-systems:

Multiple Security Systems
-------------------------

You can run multiple tenants on the same |ivy-engine| by creating a security
system per tenant. This makes sense for smaller applications. Then, you can
create a security system per customer and deploy the application(s) per
customer. A security system is isolated from other security systems. This also
applies to the workflow context. A process or task lives in a workflow context,
which you can equate with the security context. A user cannot view data from
another security context.

However, scaling up and down can be difficult with this approach. 

The disadvantage of this solution is that programming errors can lead to
unwanted access to data of other tenants. 

This cannot happen with the :ref:`multi-engine <multi-tenancy-engines>`
solution. 

|

.. graphviz:: multiple-security-systems.dot
  :align: center

|
