.. _microsoft-entra-id:

Microsoft Entra ID
==================

To integrate the |ivy-engine| with Microsoft Entra ID as an Identity
Provider, you first need to :ref:`create an application in Microsoft Entra ID <microsoft-entra-id-app>`.
From which you need at least the following settings:

- the :code:`TenantId` (Directory (tenant) ID)
- the :code:`ClientId` (Application ID) and
- the :code:`ClientSecret` (Secret Value).

It is sufficient to copy the following template and adjust the values. The
:ref:`Engine Cockpit <engine-cockpit-security-system-detail>` offers a detailed
configuration page to connect to Microsoft Entra ID.

**Template**

.. literalinclude:: ../../../../../target/resources/includes/idp/entra/ivy-identity-provider-microsoft-entra-id.yaml
  :language: yaml
  :linenos:

**Reference**

.. literalinclude:: ../../../../../target/resources/includes/idp/entra/microsoft-entra-id-reference.yaml
  :language: yaml
  :linenos:

.. toctree::
    :maxdepth: 1
    :hidden:

    microsoft-entra-id-app
