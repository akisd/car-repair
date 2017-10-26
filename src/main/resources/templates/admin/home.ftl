
</html>

<#import "/spring.ftl" as spring/>
<head>
    <title>Home Admin</title>
        <#include "/base_libraries/head.ftl"/>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
    <body>
    <#include "/Admin/menu_bar.ftl"/>
<div class="container">
    <table class="table table-striped">

   <h3>Last Services </h3>
   <br>
         <thead>
               <tr>
               <th>Service ID</th>
                 <th>Description</th>
                 <th>Status</th>
                 <th>Date</th>
                 <th>Type</th>
                 <th>Vehicle</th>
                 <th>Plate</th>
                 <th>VAT</th>
               </tr>
         </thead>
     <tbody>
<#if repairs??>
    <#list repairs as repair>
               <tr>
                 <td>#${repair.repairId}</td>
                 <td>${repair.description}</td>
                 <td><#if repair.status==0>Pending<#elseif repair.status==1>In progress<#else>Completed</#if></td>
                 <td>${repair.repairDate?datetime.iso?string("dd/MM/yyyy HH:mm:ss")}</td>
                 <td><#if repair.type>Big<#else>Small</#if></td>
                 <td>${repair.getVehicle().getMember().getFirstname()} ${repair.getVehicle().getMember().getLastname()}</td>
                 <th>${repair.getVehicle().getPlate()}</th>
                 <td>${repair.getVehicle().getMember().getVat()}</td>
               </tr>
    </#list>
     </tbody>
               </table>
               <#else>
               There is no Service for today
</#if>

</div>
<#include "/base_libraries/footer.ftl"/>
<#include "/base_libraries/js.ftl"/>
<script>
                function myFunction() {
                    var input, filter, table, tr, td, i;
                    input = document.getElementById("myInput");
                    filter = input.value.toUpperCase();
                    table = document.getElementById("myTable");
                    tr = table.getElementsByTagName("tr");
                    for (i = 0; i < tr.length; i++) {
                        td = tr[i].getElementsByTagName("td")[5];
                        if (td) {
                            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                                tr[i].style.display = "";
                            } else {
                                tr[i].style.display = "none";
                            }
                        }
                    }
                }
            </script>
    </body>
