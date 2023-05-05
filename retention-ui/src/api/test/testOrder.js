import request from '@/utils/request'

// 查询订单测试列表
export function listTestOrder(query) {
  return request({
    url: '/test/testOrder/list',
    method: 'get',
    params: query
  })
}

// 查询订单测试详细
export function getTestOrder(id) {
  return request({
    url: '/test/testOrder/' + id,
    method: 'get'
  })
}

// 新增订单测试
export function addTestOrder(data) {
  return request({
    url: '/test/testOrder',
    method: 'post',
    data: data
  })
}

// 修改订单测试
export function updateTestOrder(data) {
  return request({
    url: '/test/testOrder',
    method: 'put',
    data: data
  })
}

// 删除订单测试
export function delTestOrder(id) {
  return request({
    url: '/test/testOrder/' + id,
    method: 'delete'
  })
}
