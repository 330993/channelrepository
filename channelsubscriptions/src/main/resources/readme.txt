**************************************************************************************
	Functionality based on Role as below
	------------------------------------
	Admin:
		add and view the Channel
		Add and view the Package
		Add and view the Package
		view the subscribtion of users
		
	Operator:
		View the Channel
		Add and view the Package
		Add and View the Package
		view the subscription
		
	User:
		View the Channel
		view the package
		view the package
		subscribe and view the subscription
		
************************************************************************************		
	Steps to Deployments on AWS
	---------------------------
		1.> Create Account on AWS
		2.> Login with valid Credential
		3.> Create the Instance
		4.> Connect with instance once instance is up
		5.> install the Java (JDK and JRE)
		6.> install database 
		7.> Configure the security group for inbound to access the db and api from anywhere as per requirement
		8.> Create the Elastic ip and associate with associate with instance
		9.> Connect the database and create the database/schema
		10.> Update the database Configuration in SpringBoot Application as per database available on cloud instance
		11.> Create the JAR file of SpringBoot Application
		12.> Create the folder on instance to upload the jar in that folder and provide the all access
		13.> upload the Jar with any Web Client 
		14.> Run the Application.

