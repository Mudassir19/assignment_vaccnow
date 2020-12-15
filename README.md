# assignment_vaccnow

this application has been created by spring boot project and mysql data basee.
please find the below end points:
1.To get all available branches:http://localhost:9090/api/allbranches
2.To get branch by Id :http://localhost:9090/api/branchId/{branchId}
3.To get vaccine per branch: http://localhost:9090/api/branchId/{branchId}/availability/{branchName}
4.To order the vaccine:http://localhost:9090/api/order/vacciene
once order placed successfull, mail will be triggered to end user.
6.Get vaccine by branch name: http://localhost:9090/api//branch/{branchName}
7.To create the branch: http://localhost:9090/api/create/branch
