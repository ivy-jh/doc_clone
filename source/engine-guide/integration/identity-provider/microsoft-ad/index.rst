.. _microsoft-ad:

Microsoft Active Directory
==========================

The |ivy-engine| connects to the traditional Microsoft Active Directory via LDAP. In most cases,
it is sufficient to copy the template below and adjust the values.
However, there are many detailed settings that you can find in the reference. The
:ref:`Engine Cockpit <engine-cockpit-security-system-detail>`
offers a detailed configuration page to connect Microsoft Active Directory.


**Template**

.. literalinclude:: ../../../../../target/resources/includes/idp/msad/ivy-identity-provider-microsoft-ad.yaml
  :language: yaml
  :linenos:


**Reference**

.. literalinclude:: ../../../../../target/resources/includes/idp/msad/microsoft-ad-reference.yaml
  :language: yaml
  :linenos:
