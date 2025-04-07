.. _keycloak:

Keycloak
========

The |ivy-engine| supports Keycloak as an identity provider. You first need to
:ref:`create client in Keycloak <keycloak-setup>`. From which you need at
least the following settings:

- the :code:`Realm` (name of the realm)
- the :code:`ClientId` (Client identifier)
- the :code:`ClientSecret` (Secret value)

Furthermore you need the :code:`Url` of your Keycloak instance, when the Axon
Ivy Engine should communicate via a different URL in the background then you can
additionally specify the :code:`BackendUrl`. In most cases, it is sufficient to
copy the template below and adjust the values. However, there are many detailed
settings that you can find in the reference. The :ref:`Engine Cockpit
<engine-cockpit-security-system-detail>` offers a detailed configuration page to
connect Keycloak.

**Template**

.. literalinclude:: ../../../../../target/resources/includes/idp/keycloak/ivy-identity-provider-keycloak.yaml
  :language: yaml
  :linenos:


**Reference**

.. literalinclude:: ../../../../../target/resources/includes/idp/keycloak/keycloak-reference.yaml
  :language: yaml
  :linenos:

.. toctree::
    :maxdepth: 1
    :hidden:

    setup
