.. _identity-provider:

Identity Provider
=================

The |ivy-engine| allows you to connect external Identity Providers (IdP) 
to automatically create, maintain, and deactivate your workflow users.
|ivy-engine| never removes or deletes users, it just deactivates them.

|ivy-engine| currently offers interfaces for four different Identity Providers:

.. toctree::
    :maxdepth: 1

    keycloak/index
    microsoft-entra-id/index
    microsoft-ad/index
    novell-edirectory/index

If an Identity Provider supports daily user synchronization, 
you can make the following settings for all of your Identity Providers:

.. _ivy-identity-provider-yaml:

.. literalinclude:: ../../../../target/resources/includes/idp/synch/user-synch-reference.yaml
  :language: yaml
  :linenos:
