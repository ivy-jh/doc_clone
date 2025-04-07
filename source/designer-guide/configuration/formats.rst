.. _configuration-formats:

Formats
-------

Format configurations define how |ivy| renders values of a specific type when
outputting them to users. You can define formats for all *base types* of
*IvyScript*, i.e., ``Boolean``, ``Date``, ``DateTime``, ``Time``, ``Number``, and
``String``. Output any non-null values of those types as *formatted
strings* by calling the ``format("<format name>")`` within any script.

Examples:

::

   panel.label.text = in.selectedDate.format("long");
   out.invoice.customerNumber = wsData.customer.format("customer_id");

For several types, there are already default formats available, which can be
passed to ``format(X)``:

- ``Number``: number, integer, currency, percent
- ``Time``, ``Date`` and ``DateTime``: short, medium, long, full


Editor
~~~~~~

Formats are defined in :file:`config/formats.yaml` of your project. The
following listing shows all available properties:

.. literalinclude:: includes/formats.yaml
  :language: yaml
  :linenos:
