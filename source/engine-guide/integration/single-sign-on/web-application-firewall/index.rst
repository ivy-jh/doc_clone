.. _web-application-firewall:

Web Application Firewall
========================

A web application firewall (WAF) or web shield is a firewall which protects web
applications against attacks using the HTTP and HTTPS protocols. Combined with an
Identity and Access Management (IAM) System, it also protects against
unauthorized access and supports Single Sign-on (SSO).

Most WAF or IAM systems allow to configure a way how the user name of the
identified user is transmitted to the web applications. With the Axon Ivy Engine a
typical system landscape will look as follows:

|

.. graphviz:: overview.dot

|

The only available access point has to be the WAF. Any traffic has to be routed
via the WAF. The WAF tries to protect the web application behind it (e.g., Axon Ivy Engine)
from attacks. The WAF uses the IAM to identify users and to protect
certain resources from unauthorized access. The IAM itself may use a directory
server like Microsoft Active Directory to authenticate users. The WAF can be configured
to provide the name of the identified user either as HTTP header or HTTP cookie
to the web application (Axon Ivy Engine).
