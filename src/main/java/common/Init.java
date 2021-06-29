package common;

import apiUtils.Rest_API;
import utils.utility;

public interface Init {
    Rest_API restApi = new Rest_API();
    utility util = new utility();
}
