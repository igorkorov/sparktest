<custom7Tag>
   <style>
      ul {
         list-style-type: none;
      }
   </style>
   <ul>
      <li each = { cities } >
         <input type = "checkbox" checked = { done }> { city } - { country }
      </li>
   </ul>
   <script>
      this.cities = [
         { city : "Shanghai" , country:"China" , done: true },
         { city : "Seoul"    , country:"South Korea" },
         { city : "Moscow"   , country:"Russia"      }
      ];
   </script>
</custom7Tag>