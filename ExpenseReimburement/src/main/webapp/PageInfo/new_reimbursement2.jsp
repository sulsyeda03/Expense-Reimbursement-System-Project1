</td>
</tr>
<tr>
 <td style="text-align: right;">
   <label for="exp_date">Date Expense Occured </label>
 </td>
 <td>
   <input type="date" class="form-control" style="width: 100%;" id="exp_date" name="exp_date"
     placeholder="yyyy-mm-dd" onclick="validDate()" required="required">
 </td>
</tr>
<tr>
 <td style="text-align: right;">
   <label for="category">Expense Category </label>
 </td>
 <td>
   <select id="category" name="category" style="width: 100%; height:34px; " required="required">
     <option value="Lodging">Lodging</option>
     <option value="Travel">Travel</option>
     <option value="Food">Food</option>
     <option value="Other">Other</option>
   </select>
 </td>
</tr>
<tr>
 <td style="text-align: right;">
   <label for="merchant">Merchant Name </label>
 </td>
 <td>
   <input type="text" class="form-control" style="width: 100%;" id="merchant" name="merchant"
     placeholder="Enter Merchant Name" required="required">
 </td>
</tr>
<tr>
 <td style="text-align: right;">
   <label for="amt">Reimbursement Amount </label>
 </td>
 <td>
   <div class="currency-wrap">
   <span class="currency-code">$</span>
   <input class="text-currency" type="number" id="amt" name="amt" maxlength="12" required="required"
       step="0.01" placeholder="0.00" style=" height: 34px; width: 98%;" ></div>
 </td>
</tr>
<tr>
 <td style="text-align: right;">
   <label for="memo">Reimbursement Notes </label>
 </td>
 <td>
 <textarea style="width: 100%; height: 155px;" id="memo" name="memo" placeholder="Add comments" name="comment" required></textarea>
 </td>
</tr>
<tr>
 <td></td>
 <td>
   <button type="submit" class="btn btn-info" style="width: 100%;">Submit</button>
 </td>
</tr>
</table>
</form>
</div>
