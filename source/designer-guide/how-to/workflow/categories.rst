.. _workflow-categories:

Categories
----------


Start, Case, and Task Categories
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

You can assign a Start, Case, or Task to a category. A category is a structured
String (e.g., ``Finance/Invoices``). It categorizes Starts, Cases, or Tasks into
a hierarchical structure. It is an important identification attribute besides
the name of a Start, Case, or Task.

The ``Category`` API allows getting localized information from the CMS.
For example, the ``name`` of the category ``Finance/Invoices`` is stored in the
CMS at ``/Categories/Finance/Invoices/name``.

To display a tooltip or an icon for a category on start lists, configure
the ``tooltip`` and ``cssIcon`` in the CMS (i.e.,``/Categories/Finance/Invoice/cssIcon``).

The following example shows a simple use of a category on the Case level.
The API on the Task level is identical.

::

   ivy.case.setCategoryPath("Finance/Invoices");

   String categoryName = ivy.case.getCategory().getName(); // EN: "Invoices", DE: "Rechnungen"
   String categoryPath = ivy.case.getCategory().getPath(); // EN: "Finance/Invoices", DE: "Finanzen/Rechnungen"

.. tip::

   The project :ref:`WorkflowDemos <importing-demo-projects>` demonstrates the
   use of start, case, and task categorization. The case category serves to
   categorize the overall process (i.e.,Business Case). The task category serves
   to categorize a single unit of work, or a set of units of work. Because of
   the separation of case and task categorization, you can handle even complex
   use cases.

   An example: In a mid-sized company, the process to request an address change
   for a customer exists in multiple forms. There is one in the customer portal
   and one for partner agencies. The process executed by the customer portal has
   the case category 'CustomerPortal/AddressChange'. The process executed by a
   partner agency has the case category 'Partner/Customers/AddressChange'. Both
   processes invoke a task to have a user or department validate the address.
   This user or department also does the final address verification. So, in both
   cases, this task has the category 'AddressVerification'. This allows the user
   or department to filter tasks no matter where they have originated.
