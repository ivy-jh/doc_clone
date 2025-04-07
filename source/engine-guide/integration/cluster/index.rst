.. _cluster:

Cluster
=======

If you have a high load on your system or need increased resilience, consider
running the |ivy-engine| in a Cluster (|ivy-engine| Enterprise Edition). A
Cluster setup has two major advantages:

* **Performance and scalability**: 
  An |ivy-engine| Enterprise Edition can serve
  more clients than |ivy-engine| Standard Edition. If the number of your clients
  increases, you can add another Engine node to your |ivy-engine| Cluster.

* **High availability**: 
  In an |ivy-engine| Enterprise Edition installation, a single node may crash
  without affecting the other nodes that are still serving clients. However, if
  you require high availability of your |ivy-engine|, you also need to ensure
  that all other components the engine depends on (Load Balancer, Reverse
  Proxy/Web Application Firewall, Database Server, File Share, OpenSearch
  server) provide high availability.

Compared to a single node setup, the cluster is a more **complex** system, has
higher **hardware costs** and **license fees**: You need an
:ref:`enterprise-license`.

The diagram below shows an |ivy-engine| Cluster setup. A user accesses
the |ivy-engine| Cluster via a :ref:`load balancer <cluster-load-balancer>`
that routes the traffic to the :ref:`nodes <cluster-configuration>` of the cluster.
All cluster nodes share the same system database and OpenSearch server.

.. graphviz:: overview.dot

**Runtime**

We strongly recommend operating an |ivy-engine| Cluster in a containerized
environment like Docker, Kubernetes, or OpenShift. Build and run your
:ref:`container image <cluster-container>` containing all your projects and
configurations.

See our example configurations on GitHub for :link-url:`nginx
<docker-scaling-nginx>` and :link-url:`HAProxy <docker-scaling-haproxy>` on how
to set up an |ivy-engine| Cluster with docker-compose.
  

.. _cluster-restrictions:

**Restrictions**

Please consider the following restrictions if you want to run an |ivy-engine| Cluster:

1. Each node needs access to all other nodes via UDP/Multicast. 
2. Each node has to use the same system database.
3. Each node has to use the same external :ref:`OpenSearch <opensearch>`
   server (or cluster).
4. Each node has to use the same service configurations.
5. :ref:`Configuration changes <cluster-configuration-changes>` are only applied
   to the local cluster node where you made the change. 
6. :ref:`Deployment <cluster-deployment>` during runtime is not supported and
   does not work.
7. Some :ref:`operating systems <engine-system-requirements-os>` are not supported.
     
You can solve most of the restrictions by using a containerized environment with
your own :ref:`container image <cluster-container>`.

Usually, UDP/Multicast works in a single subnet only. Modern routers can
overcome this restriction if you configure them accordingly. If your environment
does not support this setup, you can change the cluster communication to TCP/IP.
TCP/IP will induce significantly higher cluster communications overhead.
Contact |ivy| for instructions regarding this setup.

.. toctree::
    :maxdepth: 1
    :hidden:

    configuration
    deployment
    license
    load-balancer
    container
