.. _novell-edirectory:

Novell eDirectory
=================

The |ivy-engine| connects to the Novell eDirectory via LDAP. In most cases,
it is sufficient to copy the template below and adjust the values. 
However, there are many detailed settings that you can find in the reference. The
:ref:`Engine Cockpit <engine-cockpit-security-system-detail>`
offers a detailed configuration page to connect Novell eDirectory.


**Template**

.. literalinclude:: ../../../../../target/resources/includes/idp/novel/ivy-identity-provider-novell-edirectory.yaml
  :language: yaml
  :linenos:

**Reference**

.. literalinclude:: ../../../../../target/resources/includes/idp/novel/novell-edirectory-reference.yaml
  :language: yaml
  :linenos:
