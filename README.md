formazione-soap-camel-cxf
======================================================
Author: Davide Falcone  
Technologies: Camel, CXF, SOAP  

Summary : simple project, code first based, using Camel, CXF and SOAP based on Red Hat Quickstarts


Build and Deploy
-------------------------

1. Run `mvn clean install` to build the quickstart.
2. Start Red Hat Fuse 7 by running bin/fuse (on Linux) or bin\fuse.bat (on Windows).
3. In the Red Hat Fuse console, enter the following command:

        bundle:install -s mvn:org.example/formazione-soap-camel-cxf/1.0-SNAPSHOT

4. Fuse should give you an id when the bundle is deployed

5. You can check that everything is ok by issuing  the command:

        bundle:list
   your bundle should be present at the end of the list


Use the bundle
---------------------

To use the application be sure to have deployed the quickstart in Fuse as described above. 

1. Run 'mvn -Pqtest test'

Or open 'http://localhost:8181/cxf/' in a browser to see 'PersonEndpoint' listed as a SOAP service.

Undeploy the Archive
--------------------

To stop and undeploy the bundle in Fuse:

1. Enter `bundle:list` command to retrieve your bundle id
2. To stop and uninstall the bundle enter

        bundle:uninstall <id>
