package com.cap.delivery.dao;

import com.cap.delivery.model.SearchDto;
import com.cap.delivery.model.SearchResponseVO;

public interface BoardDao {
SearchResponseVO lookupResult(SearchDto searchDto);
}
