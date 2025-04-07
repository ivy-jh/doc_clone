.. _security:

Security
********

Today the internet is a war zone. As soon as your Axon Ivy Engine is publicly available over the internet 
bots will scan it to find security holes and try to attack it.
It is important that you operate an Axon Ivy Engine in a safe way whether it is running in a relatively "secure"
intranet environment or it is accessible via the internet. 
This chapter describes how to operate an Axon Ivy Engine safely. 

#. Run the Axon Ivy Engine behind a fully patched `web application firewall (WAF) <https://en.wikipedia.org/wiki/Web_application_firewall>`_ 
   or at least a :ref:`reverse proxy server <reverse-proxy>` (like NGINX, Apache HTTP Server, or IIS).
#. :ref:`Disable direct access <reverse-proxy-secure-port>` to the Axon Ivy Engine.
#. Only allow access to the URLs of your application and :ref:`block all other access <reverse-proxy-secure-path>`.
#. Run the Axon Ivy Engine with a **dedicated system user** and **database users with limited access rights**.
#. Run the **latest Axon Ivy Engine** major version with all updates marked as
   :ref:`security-relevant <engine-security-issues>`.
#. Only serve users via :ref:`HTTPS <reverse-proxy-secure-https>` (configured on the reverse proxy).
#. **Document** and **automate** the server setup.
#. Ensure that the operations provider performs **daily backups** (database, relevant
   engine folders) which can also be restored...

|

.. graphviz:: overview.dot

|


Read more about other security tweaks which you can apply to your Axon Ivy Engine:

.. toctree::
   :maxdepth: 1

   axonivy-engine/features
   axonivy-engine/permissions
   axonivy-engine/security-issues
   http-headers
   csrf-attack-prevention
   dos-brute-force-attack-prevention
