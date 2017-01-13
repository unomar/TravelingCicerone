package com.weissbrewing.cicerone.domain.untappdAPI;

/**
 * Created by kevinweiss on 1/13/17.
 */
public class Meta
{
    private int code;

    private Timing response_time;

    private Timing init_time;

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public Timing getResponse_time()
    {
        return response_time;
    }

    public void setResponse_time(Timing response_time)
    {
        this.response_time = response_time;
    }

    public Timing getInit_time()
    {
        return init_time;
    }

    public void setInit_time(Timing init_time)
    {
        this.init_time = init_time;
    }

    /**
     * Custom toString implementation
     * @return
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("code=");
        sb.append(code);
        sb.append(" response_time=[");
        sb.append(response_time.toString());
        sb.append("] init_time=[");
        sb.append(init_time.toString());
        sb.append("]");
        return sb.toString();
    }
}
