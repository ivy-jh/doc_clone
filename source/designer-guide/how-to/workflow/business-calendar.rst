
.. _business-calendar:

Business Calendar
-----------------

A business calendar defines the official business hours and business days.
Business calendars are organized in a tree structure, with a root calendar
defining the application default values and child calendars inheriting all
values from their ancestor, e.g.,

-  IvyGlobal
   
   -  Switzerland
   
      -  Zurich
      -  Zug
   
   -  Austria
   -  Germany

Above, you see the business calendar definitions for |ivy|. We define a global
root with three countries. For Switzerland, we also add two regions, Zurich and
Zug, each with their local public holidays besides the ones they inherit from
Switzerland and IvyGlobal.

Use business calendars API :public-api:`IBusinessCalendar
</ch/ivyteam/ivy/application/calendar/IBusinessCalendar.html>` to make
calculations related to business days or business hours. This is very useful for
process steps that need to work with business days, rather than with calendar
days.

For example:

-  A Service Level Agreement (SLA) defines that a task needs to be processed by
   the end of the next business day. Implement this by setting the task expiry
   to the business day after the next.

   If the default calendar does not apply, you can set the business calendar on
   the case:
   
   .. figure:: /_images/business-calendar/business-calendar-request-start.png

   Set the timeout duration to two business days, using the current calendar.
   
   .. figure:: /_images/business-calendar/business-calendar-task-switch.png

-  A payment application automatically corrects the payment date entered to the
   next business day if necessary:

   ::

      // e.g., on the Start tab of a Request Start Inscription Mask
      out.paymentDate = ivy.cal.getWorkDayIn(out.paymentDate, 0);

You can set a calendar on tasks, cases, or applications.
The variable (ivy.cal) references the calendar that is valid for the
current context. It determines the valid calendar by checking:

#. the current task
#. the current case
#. the current application
#. the root calendar of the current application, if none of the above have been
   set explicitly.

You can use another calendar by referencing it by its name:

::

   ivy.cal.get("Zug").getWorkDayIn(2);

If you want to configure business calendars for test purposes in your
|ivy-designer| environment, you can change (or create if it doesn't exist yet)
the ``app-designer.yaml`` file in folder ``<designer_path>/configuration``. Note
that all values in this file are valid for all projects in your workspace and
that they don't get cleared after a restart.

See chapter :ref:`configuration-business-calendar` in the Engine Guide on how to
configure business calendars on your Engine instance.
