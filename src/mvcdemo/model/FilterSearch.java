package mvcdemo.model;

import mvcdemo.model.Filter;
/*import java.util.ArrayList;
import java.util.LinkedHashMap;*/
import java.util.List;

/*import com.google.gson.Gson;*/

public class FilterSearch {
	private String myList;
	private String orderBy;
	private String Search;
	private List<Filter> Filter;
	private String x;
	//private Integer count;
	
	public FilterSearch(String a){
		x = a;
	}
	/*public List<Filter> getFilterSearch() {
		return Filter;
	}
	public void setFilterSearch(Filter Filter) {
		this.Filter = Filter;
		}*/
	
	public List<Filter> getFilter() {
		return Filter;
	}
	public void setFilter(List<Filter> Filter) {
		
		this.Filter = Filter;
	}
	 
	public String getmyList() {
		return myList;
	}
	public void setmyList(String myList) {
		this.myList = myList;
	}
	public String getorderBy() {
		return orderBy;
	}
	public void setorderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getSearch() {
		return Search;
	}
	public void set(String Search) {
		this.Search = Search;
	}
	@Override
	public String toString() {
		if(this.getFilter().isEmpty()) {
			return "success";
		}
		else {
			return "fail";
		}
		}
		//return this.getCount();
		//System.out.println(this.myList);
	}
/*	public String getStringJSON() {
		return x;
	}*/
	/*public static void main(String args[]) {
		Filter filter = null;
		
		Gson gson = new Gson();
		filter = gson.fromJson(obj, FilterSearch.class);
	}*/

